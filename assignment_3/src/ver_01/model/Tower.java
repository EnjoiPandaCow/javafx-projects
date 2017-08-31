package ver_01.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tower implements Serializable {

    private int id;
    private List<Block> list;

    public Tower(int id) {

        this.id = id;
        list = new ArrayList<>();
    }

    public List<Block> getList() {
        return list;
    }
}
