package ver_01.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class State implements Serializable {

    private List<Block> t1Blocks;
    private List<Block> t2Blocks;
    private List<Block> t3Blocks;
    private int numMoves;
    private int numBlocks;

    public State(Tower tower1, Tower tower2, Tower tower3, int numMoves, int numBlocks) {

        t1Blocks = new ArrayList<>();
        t1Blocks.addAll(tower1.getList());

        t2Blocks = new ArrayList<>();
        t2Blocks.addAll(tower2.getList());

        t3Blocks = new ArrayList<>();
        t3Blocks.addAll(tower3.getList());
        this.numMoves = numMoves;
        this.numBlocks = numBlocks;
    }

    public List<Block> getT1Blocks() {
        return t1Blocks;
    }

    public List<Block> getT2Blocks() {
        return t2Blocks;
    }

    public List<Block> getT3Blocks() {
        return t3Blocks;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public int getNumBlocks() {
        return numBlocks;
    }

    public void printState() {

        System.out.println("Tower 1\n");
        for (Block block : t1Blocks) {
            System.out.println(block.toString());
        }
        System.out.println("Tower 2\n");
        for (Block block : t2Blocks) {
            System.out.println(block.toString());
        }
        System.out.println("Tower 3\n");
        for (Block block : t3Blocks) {
            System.out.println(block.toString());
        }
    }
}
