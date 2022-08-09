export function printTree(treeNode) {
    return getNodes(treeNode);
}

export function checkTreeEqualness(treeNode1, treeNode2){
    return (printTree(treeNode1).toString() == printTree(treeNode2).toString()) ? true : false;
}

export function reverse(treeNode) {
    if (
        treeNode.right != null
        && treeNode.left != null
    ) {
        let tmpLeft = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tmpLeft;
        reverse(treeNode.left);
        reverse(treeNode.right);
    }

    return treeNode;
}

export function getNodes(tree) {
    let nodes = Object.values(tree);
    if (nodes[1] != null) {
        nodes[1] = getNodes(nodes[2]);
    }
    if (nodes[2] != null) {
        nodes[2] = getNodes(nodes[2]);
    }
    return nodes;
}