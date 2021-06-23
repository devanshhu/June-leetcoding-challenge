class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        List<Integer> list =  new ArrayList<Integer>();
        List<Integer> prev =  new ArrayList<Integer>();
        if(numRows == 0)
            return resultList;
        prev.add(1);
        list.add(1);list.add(1);
        resultList.add(prev);
        if(numRows == 1)
            return resultList;
        resultList.add(list);
        if(numRows == 2)
            return resultList;
        prev = list;
        for(int i=2;i< numRows;i++){
            list = new ArrayList<Integer>();
            // list.add(1);
            int prevElem = 0;
            for(Integer x: prev){
                list.add( x + prevElem);
                prevElem = x;
            }
            list.add(1);
            prev = list;
            resultList.add(list);
        }
        return resultList;
    }
}