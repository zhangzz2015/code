public class AndOperationOnQuadtree {
    
    interface QuadTreeNode {
        public boolean isLeaf();
        public boolean color();
        List<QuadTreeNode> getChildren();
    }
    class LeafNode implements QuadTreeNode {
        public boolean color;
        @Override
        public boolean isLeaf() {return false;}
        @Override
        public boolean color() {return this.color;}
        @Override
        public List<QuadTreeNode> getChildren() {
            throw new UnsupportedOperationException("This is a leaf node.");
        }
    }
    class NonLeafNode implements QuadTreeNode {
        @Override
        public boolean isLeaf() {return false;}
        @Override
        public boolean color() {
            return new UnsupportedOperationException("This is a nonleaf node.");
        }
        @Override
        public List<QuadTreeNode> getChildren() {
            List<QuadTreeNode> children = new ArrayList<>();
            children.add(c1);
            children.add(c2);
            children.add(c3);
            children.add(c4);
        }
        LeafNode c1;
        LeafNode c2;
        LeafNode c3;
        LeafNode c4;
    }

    public QuadTreeNode and(QuadTreeNode r1, QuadTreeNode r2) {
        if (r2.isLeaf()) return and(r2, r1);
        if (r1.isLeaf()) {
            return r1.color() == true ? r2 : r1;
        }
        // both are nonleaf
        r1.c1 = and(r1.c1, r2.c1);
        r1.c2 = and(r1.c2, r2.c2);
        r1.c3 = and(r1.c3, r2.c3);
        r1.c4 = and(r1.c4, r2.c4);
        if (!r1.c1 && !r1.c2 && !r1.c3 && !r1.c4) return new LeafNode(0);
        return r1;
    }
}