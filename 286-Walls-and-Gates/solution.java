public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    update(i-1, j, 0, rooms);
                    update(i+1, j, 0, rooms);
                    update(i, j-1, 0, rooms);
                    update(i, j+1, 0, rooms);
                }
            }
        }
    }
    
    public void update(int i, int j, int pre, int[][] rooms){
        if(i < 0 || i == rooms.length || j < 0 || j == rooms[0].length){
            return;
        }
        else{
            if(rooms[i][j] != -1 && rooms[i][j] != 0){
                if(rooms[i][j] > pre+1){
                    // System.out.println(i + " " + j);
                    rooms[i][j] = pre+1;
                    update(i-1, j, pre+1, rooms);
                    update(i+1, j, pre+1, rooms);
                    update(i, j-1, pre+1, rooms);
                    update(i, j+1, pre+1, rooms);
                }
            }
        }
    }
}