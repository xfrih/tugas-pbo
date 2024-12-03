import java.util.List;
import java.util.ArrayList;

public class Field {
    private Object[][] field;

    public Field(int depth, int width){
        field = new Object[depth][width];
    }

    public void clear(Location location){
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location){
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location){
        if(location.getRow() >= 0 && location.getRow() < getRow() && location.getCol() >= 0 && location.getCol() < getCol()){
            return field[location.getRow()][location.getCol()];
        }
        return null;
    }

    public List<Location> allFreeAdjacentLocations(Location location){
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);
        for(Location loc : adjacent){
            if(getObjectAt(loc) == null){
                free.add(loc);
            }
        }
        return free;
    }

    public Location freeAdjacentLocation(Location location){
        List<Location> free = allFreeAdjacentLocations(location);
        
        if(free.size() > 0){
            return free.get(0);
        }
        
        return null;
    }

    public List<Location> adjacentLocations(Location location){
        List<Location> locations = new ArrayList<>();
        if(location == null){
            return locations;
        }

        int row = location.getRow();
        int col = location.getCol();

        if(row > 0){
            locations.add(new Location(row - 1, col));
        }

        if(row < getRow() - 1){
            locations.add(new Location(row + 1, col));
        }

        if(col > 0){
            locations.add(new Location(row, col - 1));
        }

        if(col < getCol() - 1){
            locations.add(new Location(row, col + 1));
        }
        return locations;
    }

    public int getRow(){
        return field.length;
    }

    public int getCol(){
        return field[0].length;
    }

    public void clearAll(){
        for(int i=0;i<field.length;i++){
            for(int j=0;j<field[i].length;j++){
                field[i][j] = null;
            }
        }
    }
}