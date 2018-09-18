package ChapterOneTests;

import StringQuestions.Q1_01;
import junit.framework.Assert;
import junit.framework.TestCase;

public class Q1_01_Test extends TestCase {

	public void testIsUnique() {
		Assert.assertFalse(Q1_01.isUnique("primrose"));
	}

}
