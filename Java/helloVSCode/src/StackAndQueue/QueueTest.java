public class QueueTest<E> {

    private class Node {
        private E item;
        private Node link;

        public Node(E e, Node next)
        {
            item = e;
            link = next;
        }

        public void reLink(Node newNext)
        {
            link = newNext;
        }
    }

    // number of items
    private int n;

    // last item
    private Node last;
    // first item
    private Node first;

    // test content
    public final boolean isEmpty()
    {
        return (n == 0);
    }

    // enqueue
    public final void enqueue(E newItem)
    {
        if (n == 0)
        {
            last = new Node(newItem, null);
            first = last;
            n = 1;
            return;
        }
        if (n == 1)
        {
            E firstItem = first.item;
            Node newLast = new Node(newItem, null);
            last.reLink(newLast);
            last = newLast;
            first = new Node(firstItem, last);
            n = 2;
            return;
        }
        Node newLast = new Node(newItem, null);
        last.reLink(newLast);
        last = newLast;
        n++;
    }

    // dequeue
    public final E dequeue()
    {
        E firstItem = first.item;
        first = first.link;
        n--;
        return firstItem;
    }

    // size
    public final int size()
    {
        return n;
    }

    public static void main(String[] args)
    {
        QueueTest<String> queue = new QueueTest<String>();
        System.out.println(queue.isEmpty());
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue("fourth");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());

    }
}