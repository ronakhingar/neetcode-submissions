class PrefixTree {

    TreeNode head;
    public PrefixTree() {
         head = new TreeNode();

    }

    public void insert(String word) {

        TreeNode node=head;
        for(char c: word.toCharArray()){
            
            if(node.tree[(int)c]==null){
            node.tree[(int)c]= new TreeNode();
            }
            node= node.tree[(int)c];
        }
        node.isWord=true;
    }

    public boolean search(String word) {

                TreeNode node=head;
        for(char c: word.toCharArray()){
            if(node.tree[(int)c]==null){
                return false;
            }
            node= node.tree[(int)c];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {

                TreeNode node=head;
        for(char c: prefix.toCharArray()){
            if(node.tree[(int)c]==null){
                return false;
            }
            node= node.tree[(int)c];
        }
        return true;

    }
}

class TreeNode{

    TreeNode[] tree;
    boolean isWord;

public TreeNode(){
    tree= new TreeNode[256];
}

}
