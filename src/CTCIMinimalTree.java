public class CTCIMinimalTree {
    public static void main(String[] args) {
        try{
            CTCIMinimalTree obj = new CTCIMinimalTree();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        int[] sortedArray = new int[]{1,3,5,6,7,8,11,14,15,18,19,21,24,25,27};
        Node topThing = sortedTree(sortedArray,new Node(sortedArray[sortedArray.length/2]),0,sortedArray.length-1);
        System.out.println("Node:" + topThing.num);
        System.out.println("Node:" + topThing.leftNode.num);
        System.out.println("Node:" + topThing.rightNode.num);
        System.out.println("Node:" + topThing.leftNode.leftNode.num);
        System.out.println("Node:" + topThing.leftNode.rightNode.num);
        System.out.println("Node:" + topThing.rightNode.leftNode.num);
        System.out.println("Node:" + topThing.rightNode.rightNode.num);
        System.out.println("Node:" + topThing.leftNode.leftNode.leftNode.num);
        System.out.println("Node:" + topThing.leftNode.leftNode.rightNode.num);
        System.out.println("Node:" + topThing.leftNode.rightNode.leftNode.num);
        System.out.println("Node:" + topThing.leftNode.rightNode.rightNode.num);
        System.out.println("Node:" + topThing.rightNode.leftNode.leftNode.num);
        System.out.println("Node:" + topThing.rightNode.leftNode.rightNode.num);
        System.out.println("Node:" + topThing.rightNode.rightNode.leftNode.num);
        System.out.println("Node:" + topThing.rightNode.rightNode.rightNode.num);
    }
    public Node sortedTree(int[] sortedArray,Node topNode,int low,int high){
        Node newNode = new Node(sortedArray[(low+high)/2]);
        boolean slotFound = false;
        Node runner = topNode;
        while(!slotFound){
            if(runner.num == newNode.num){
                runner = newNode;
                slotFound = true;
            }
            else if(newNode.num > runner.num){
                if(runner.rightNode == null){
                    runner.rightNode = newNode;
                    slotFound = true;
                }else{
                    runner = runner.rightNode;
                }
            }
            else if(newNode.num < runner.num){
                if(runner.leftNode == null){
                    runner.leftNode = newNode;
                    slotFound = true;
                }else{
                    runner = runner.leftNode;
                }
            }
        }
        if(low != high){
            if(high != 0){
                sortedTree(sortedArray,topNode,low,(low+high)/2 - 1);
            }
            if(low != sortedArray.length){
                sortedTree(sortedArray,topNode,(low+high)/2 + 1,high);
            }
        }
        return topNode;
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node(){}
    public Node(int num){
        this.num = num;
    }
    public Node(int num,Node leftNode,Node rightNode){
        this.num = num;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}