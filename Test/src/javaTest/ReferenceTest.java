package javaTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.lang.ref.FinalReference;
import java.lang.ref.Finalizer;

public class ReferenceTest {

	public ReferenceTest() {}

	public static void main(String[] args) {
		//Java的四個引用：強引用、軟引用、弱引用、虛引用
		//https://allenhsieh1992.com/posts/java/java-reference/
		//強引用

		//軟引用
		Reference<?> softReference = new SoftReference<>(null);
		//弱引用
		Reference<?> weakReference = new WeakReference<>(null);
		//ReferenceQueue
		ReferenceQueue<?> referenceQueue = new ReferenceQueue<>();
		//虛引用
		Reference<?> phantomReference = new PhantomReference<>(null, null);
		//WeakHashMap
		Map<?, ?> weakHashMap = new WeakHashMap<>();
		//FinalReference與Finalizer
		Reference finalReference = new FinalReference();
		FinalReference finalizer = new Finalizer();

	}

}
