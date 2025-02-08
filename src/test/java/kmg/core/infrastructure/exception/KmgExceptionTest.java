package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.model.impl.KmgReflectionModelImpl;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMG例外テスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@ExtendWith(MockitoExtension.class)
public class KmgExceptionTest {

    /**
     * コンストラクタのテスト - メッセージタイプのみを指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypes() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String             expectedMessage  = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプとメッセージ引数を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]           expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String             expectedMessage  = "テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプと原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String             expectedMessage  = "{0}がありません。";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * コンストラクタのテスト - メッセージタイプ、メッセージ引数、原因を指定した場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testConstructor_withMessageTypesArgsAndCause() {

        /* 期待値の定義 */
        final KmgMsgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]           expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String             expectedMessage  = "テスト引数1がありません。";
        final Throwable          expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(expectedMsgTypes, expectedMsgArgs, expectedCause);

        /* 検証の準備 */
        final String             actualMessage  = testException.getMessage();
        final KmgMsgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]           actualMsgArgs  = testException.getMessageArgs();
        final Throwable          actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - メッセージ引数がある場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_withArgs() {

        /* 期待値の定義 */
        final int expectedCount = 2;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が一致しません");

    }

    /**
     * getMessageArgsCount メソッドのテスト - メッセージ引数がnullの場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessageArgsCount_withNullArgs() {

        /* 期待値の定義 */
        final int expectedCount = 0;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final int actualCount = testException.getMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージ引数の数が0であること");

    }

    /**
     * getMessagePatternArgsCount メソッドのテスト
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessagePatternArgsCount() {

        /* 期待値の定義 */
        final int expectedCount = 1;

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final int actualCount = testException.getMessagePatternArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedCount, actualCount, "メッセージパターンの引数の数が一致しません");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - メッセージ引数の数が一致する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsMatchMessageArgsCount_matching() {

        /* 期待値の定義 */

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertTrue(actualIsMatch, "メッセージ引数の数が一致しているか");

    }

    /**
     * isMatchMessageArgsCount メソッドのテスト - メッセージ引数の数が一致しない場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testIsMatchMessageArgsCount_notMatching() {

        /* 期待値の定義 */
        final boolean expectedIsMatch = false;

        /* 準備 */
        final Object[] testMsgArgs = {
            "テスト引数1", "テスト引数2"
        };

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100, testMsgArgs);

        /* 検証の準備 */
        final boolean actualIsMatch = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedIsMatch, actualIsMatch, "メッセージ引数の数が一致していないか");

    }

    /**
     * getMessagePattern メソッドのテスト - メッセージパターンを取得する場合
     */
    @Test
    @SuppressWarnings("static-method")
    public void testGetMessagePattern() {

        /* 期待値の定義 */
        final String expectedPattern = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgException testException = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);

        /* 検証の準備 */
        final String actualPattern = testException.getMessagePattern();

        /* 検証の実施 */
        Assertions.assertEquals(expectedPattern, actualPattern, "メッセージパターンが一致しません");

    }

    /**
     * setMessageCounts メソッドのテスト - メッセージパターンが空の場合
     *
     * @throws Exception
     *                   リフレクション操作で発生する可能性のある例外
     */
    @Test
    @SuppressWarnings("static-method")
    public void testSetMessageCounts_emptyMessagePattern() throws Exception {

        /* 期待値の定義 */
        final int expectedMessageArgsCount        = 0;
        final int expectedMessagePatternArgsCount = 0;

        /* 準備 */
        final KmgException           testException   = new KmgException(KmgMsgMessageTypes.KMGMSGE11100);
        final KmgReflectionModelImpl reflectionModel = new KmgReflectionModelImpl(testException);

        // privateフィールドのmessagePatternを空文字列に設定
        reflectionModel.set("messagePattern", "");
        reflectionModel.getMethod("setMessageCounts");

        /* 検証の準備 */
        final int     actualMessageArgsCount        = testException.getMessageArgsCount();
        final int     actualMessagePatternArgsCount = testException.getMessagePatternArgsCount();
        final boolean actualIsMatchMessageArgsCount = testException.isMatchMessageArgsCount();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMessageArgsCount, actualMessageArgsCount, "メッセージ引数の数が一致する");
        Assertions.assertEquals(expectedMessagePatternArgsCount, actualMessagePatternArgsCount, "メッセージパターンの引数の数が一致する");
        Assertions.assertTrue(actualIsMatchMessageArgsCount, "メッセージ引数の数が一致しているか");

    }
}
