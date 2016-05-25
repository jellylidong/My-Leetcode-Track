public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    update(rooms, i-1, j, 0);
                    update(rooms, i+1, j, 0);
                    update(rooms, i, j-1, 0);
                    update(rooms, i, j+1, 0);
                }
            }
        }
    }
    
    public void update(int[][] rooms, int i, int j, int pre){
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length)
            return;
        if(rooms[i][j] != 0 && rooms[i][j] != -1){
            if(rooms[i][j] > pre + 1){
                rooms[i][j] = pre+1;
                update(rooms, i-1, j, pre+1);
                update(rooms, i+1, j, pre+1);
                update(rooms, i, j-1, pre+1);
                update(rooms, i, j+1, pre+1);

            }
        }
    }
}