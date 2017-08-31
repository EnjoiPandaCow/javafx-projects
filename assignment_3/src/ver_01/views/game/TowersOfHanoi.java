package ver_01.views.game;

import alerts.GameWonAlert;
import alerts.InvalidMoveAlert;
import ver_01.Main;
import ver_01.managers.SaveManager;
import ver_01.model.Block;
import ver_01.model.Game;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TowersOfHanoi {

    @FXML
    private ComboBox<Integer> comboBox;
    @FXML
    private Button tower1Button;
    @FXML
    private Button tower2Button;
    @FXML
    private Button tower3Button;
    @FXML
    private VBox tower01;
    @FXML
    private VBox tower02;
    @FXML
    private VBox tower03;
    @FXML
    private Button newGameButton;
    @FXML
    private Label movesLabel;
    private Game game;

    private ObservableList<Node> tower01List;
    private ObservableList<Node> tower02List;
    private ObservableList<Node> tower03List;
    private ObservableList<Node> lastList;

    private SaveManager saveManager;

    public static void gameWon() {
        System.out.println("Won");
    }

    @FXML
    private void initialize() {

        saveManager = Main.saveManager;
        comboBox.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10);
        comboBox.setValue(3);
        comboBox.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {

                if(!oldValue.equals(newValue)) {
                    Main.setLoadGame(false);
                    startGame();
                }
            }
        });

        tower01List = tower01.getChildren();
        tower02List = tower02.getChildren();
        tower03List = tower03.getChildren();
        startGame();
    }

    //** Called when user clicks one of the tower buttons or Vboxes **\\
    @FXML
    private void towerClicked(Event e) {

        if(game.isGameWon()) {
            return;
        }
        ObservableList<Node> currentList = buttonToList((Node) e.getSource());
        if(checkMove(currentList)) {
            moveBlocks(currentList);
        }
    }

    @FXML
    private void blockDragged(Event e) {
        System.out.println(e.getSource());
    }

    @FXML
    private void dragDropped(Event e) {
        System.out.println(e.getSource());
    }

    //** Will highlight top block & check weather move needs to be made **\\
    private boolean checkMove(ObservableList<Node> currentList) {

        if (currentList.size() > 0) {
            StackPane outerBlock = (StackPane) currentList.get(0);
            if (lastList == null) {
                lastList = currentList;
                outerBlock.getChildren().get(0).getStyleClass().add("highlightedBlock");
                return false;
            } else if (lastList == currentList) {
                outerBlock.getChildren().get(0).getStyleClass().remove("highlightedBlock");
                lastList = null;
                return false;
            } else {
                return true;
            }
        }
        return lastList != null;
    }

    /** Will send the block from the list that the block is moved from to the list that it is to be moved to.
     *  If move is legal the view is changed.
     *  Will check if game is won after every move
     */
    private void moveBlocks(ObservableList<Node> currentList) {

        if(game.moveBlock(getListId(lastList), getListId(currentList))) {
            addBlocks();
            lastList = null;
            if(game.isGameWon()) {
                if(GameWonAlert.display(game)) {
                    Main.setLoadGame(false);
                    startGame();
                }
            }
        } else {
            InvalidMoveAlert.display();
        }
    }

    //** Will return a number that will match the list location in the model **\\
    private int getListId(ObservableList<Node> list) {

         if(list == tower01List) {
             return 0;
         } else if(list == tower02List) {
             return 1;
         }
         return 2;
    }

    //** Will match a list to the button clicked **\\
    private ObservableList<Node> buttonToList(Node btn) {

         if(btn instanceof Button) {
             if(btn == tower1Button) {
                 return tower01List;
             } else if(btn == tower2Button) {
                 return tower02List;
             }
             return tower03List;
         } else {
             if(btn == tower01) {
                 return tower01List;
             } else if(btn == tower02) {
                 return tower02List;
             }
         }
         return tower03List;
    }

    private void startGame() {

         if(Main.isLoadGame()) {
             game = new Game(Main.getLastState());
             saveManager.setSavedGame(game.getCurrentState());
         } else {
             game = new Game(comboBox.getValue());
             saveManager.setSavedGame(game.getCurrentState());
         }
         System.out.println(game);
         addBlocks();
    }

    @FXML
    private void restartClicked() {
         Main.setLoadGame(false);
         startGame();
    }

    @FXML
    private void checkMoves() {
         game.resetMove();
         addBlocks();
    }

    //** Will be called every time that game model changes **\\
    private void addBlocks() {

        tower01List.clear();
        tower02List.clear();
        tower03List.clear();
        ObservableList<Node> currentList;
        for(int j = 0; j < 3; j++) {
            if(j == 0) {
                currentList = tower01List;
            } else if (j == 1) {
                currentList = tower02List;
            } else {
                currentList = tower03List;
            }
            for(int i = game.getTowerList(j).size(); i > 0; i--) {
                Block block = game.getTowerList(j).get(i - 1);
                Insets padding = new Insets(0, block.getSize() * 20, 0, block.getSize() * 20);
                StackPane pane = new StackPane();
                StackPane outerPane = new StackPane(pane);
                outerPane.setPadding(padding);
                pane.setPrefSize(100, 20);
                pane.getStyleClass().add("blocks");
                currentList.add(currentList.size(), outerPane);
            }
        }
        saveManager.setSavedGame(game.getCurrentState());
        movesLabel.setText(Integer.toString(game.getNumMoves()));
    }
}
