public abstract class AbstractTree<E> implements Tree<E> {
  @Override /** In-order traversal from the root*/
  public void inorder() {
  }

  @Override /** Post-order traversal from the root */
  public void postorder() {
  }

  @Override /** Pre-order traversal from the root */
  public void preorder() {
  }

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}