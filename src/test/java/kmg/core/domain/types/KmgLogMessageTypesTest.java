package kmg.core.domain.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGログメッセージの種類のテスト<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgLogMessageTypesTest {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @since 0.1.0
     */
    public KmgLogMessageTypesTest() {

        // 処理なし
    }

    /**
     * get メソッドのテスト - 正常系:基本的な値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGet_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * getCode メソッドのテスト - 正常系:コードの取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetCode_normalBasicCode() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.getCode();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * getDefault メソッドのテスト - 正常系:デフォルト値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDefault_normalDefaultValue() {

        /* 期待値の定義 */
        final KmgLogMessageTypes expected = KmgLogMessageTypes.NONE;

        /* テスト対象の実行 */
        final KmgLogMessageTypes actual = KmgLogMessageTypes.getDefault();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "デフォルト値が一致しません");

    }

    /**
     * getDetail メソッドのテスト - 正常系:詳細情報の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDetail_normalBasicDetail() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.getDetail();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * getDisplayName メソッドのテスト - 正常系:表示名の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetDisplayName_normalBasicDisplayName() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.getDisplayName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * getEnum メソッドのテスト - 正常系:存在する値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnum_normalExistingValue() {

        /* 期待値の定義 */
        final KmgLogMessageTypes expected = KmgLogMessageTypes.KMGLOGI12000;

        /* 準備 */
        final String key = "KMGLOGI12000"; //$NON-NLS-1$

        /* テスト対象の実行 */
        final KmgLogMessageTypes actual = KmgLogMessageTypes.getEnum(key);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * getEnum メソッドのテスト - 準正常系:存在しない値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetEnum_semiNonExistingValue() {

        /* 期待値の定義 */
        final KmgLogMessageTypes expected = KmgLogMessageTypes.NONE;

        /* 準備 */
        final String testValue = "INVALID";

        /* テスト対象の実行 */
        final KmgLogMessageTypes actual = KmgLogMessageTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getInitValue メソッドのテスト - 正常系:初期値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetInitValue_normalInitialValue() {

        /* 期待値の定義 */
        final KmgLogMessageTypes expected = KmgLogMessageTypes.NONE;

        /* テスト対象の実行 */
        final KmgLogMessageTypes actual = KmgLogMessageTypes.getInitValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "初期値が一致しません");

    }

    /**
     * getValue メソッドのテスト - 正常系:値の取得
     *
     * @since 0.1.0
     */
    @Test
    public void testGetValue_normalBasicValue() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * toString メソッドのテスト - 正常系:KMGLOGI12000の文字列表現
     *
     * @since 0.1.0
     */
    @Test
    public void testToString_normalKMGLOGI12000() {

        /* 期待値の定義 */
        final String expected = "KMGLOGI12000"; //$NON-NLS-1$

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.KMGLOGI12000;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません"); //$NON-NLS-1$

    }

    /**
     * toString メソッドのテスト - 正常系:NONEの文字列表現
     *
     * @since 0.1.0
     */
    @Test
    public void testToString_normalNone() {

        /* 期待値の定義 */
        final String expected = "NONE";

        /* 準備 */
        final KmgLogMessageTypes testType = KmgLogMessageTypes.NONE;

        /* テスト対象の実行 */
        final String actual = testType.toString();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "NONEの場合、\"NONE\"が返されること");

    }
}
