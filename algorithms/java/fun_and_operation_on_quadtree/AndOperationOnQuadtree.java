public class AndOperationOnQuadtree {
    
    interface QuadTreeNode {
		public boolean isLeaf();
		public boolean color();
		List<QuadTreeNode> getChildren();
	}

	class LeafNode implements QuedTreeNode {
		public boolean color; // false is black, white is true
		LeafNode(boolean color) {
			this.color = color;
		}
		@Override
		public boolean isLeaf() {
			return true;
		}
		@Override
		public boolean color() {
			return this.color;
		}
		@Override
		public List<QuadTreeNode> getChildren() {
			throw new UnsupportedOperationException("This is a leaf node.");
		}
	}

	class NonLeafNode implements QuadTreeNode {
		QuadTreeNode c1;
		QuadTreeNode c2;
		QuadTreeNode c3;
		QuadTreeNode c4;

		@Override
		public boolean isLeaf() {
			return false;
		}
		@Override
		public boolean color() {
			throw new UnsupportedOperationException("This is a non-leaf node.");
		}
		@Override
		public boolean List<QuadTreeNode> getChildren() {
			List<QuadTreeNode> children = new ArrayList<>();
			children.add(c1);
			children.add(c2);
			children.add(c3);
			children.add(c4);
		}
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
        if (!r1.c1 && !r1.c2 && !r1.c3 && !r1.c4) return new LeafNode(false);
        return r1;
    }
}
