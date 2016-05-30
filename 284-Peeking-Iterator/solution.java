// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Queue<Integer> q;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    q = new LinkedList<>();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasNext())
            return null;
        return q.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasNext()){
	        if(iterator.hasNext()){
	            q.offer(iterator.next());
	        }
	        return q.poll();
	    }
	    else
	        return null;
	}

	@Override
	public boolean hasNext() {
	    if(!q.isEmpty())
	        return true;
	    else{
	        if(iterator.hasNext()){
	            q.offer(iterator.next());
	            return true;
	        }
	        else
	            return false;
	    }
	}
}