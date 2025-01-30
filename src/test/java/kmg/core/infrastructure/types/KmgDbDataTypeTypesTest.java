package kmg.core.infrastructure.types;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * KMGＤＢ型の種類のテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
public class KmgDbDataTypeTypesTest {

    /**
     * getEnum メソッドのテスト - 存在する値の場合
     */
    @Test
    public void testGetEnum_existingValue() {

        /* 期待値の定義 */
        final KmgDbDataTypeTypes expected = KmgDbDataTypeTypes.INTEGER;

        /* 準備 */
        final String testValue = "4バイト整数";

        /* テスト対象の実行 */
        final KmgDbDataTypeTypes actual = KmgDbDataTypeTypes.getEnum(testValue);

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getName メソッドのテスト
     */
    @Test
    public void testGetName() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getName();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "名称が一致しません");

    }

    /**
     * getValue メソッドのテスト
     */
    @Test
    public void testGetValue() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.getValue();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "値が一致しません");

    }

    /**
     * getType メソッドのテスト - Integer型の場合
     */
    @Test
    public void testGetType_integer() {

        /* 期待値の定義 */
        final Type expected = Integer.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - LocalDate型の場合
     */
    @Test
    public void testGetType_date() {

        /* 期待値の定義 */
        final Type expected = LocalDate.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.DATE;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - LocalDateTime型の場合
     */
    @Test
    public void testGetType_time() {

        /* 期待値の定義 */
        final Type expected = LocalDateTime.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.TIME;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * getType メソッドのテスト - BigDecimal型の場合
     */
    @Test
    public void testGetType_bigDecimal() {

        /* 期待値の定義 */
        final Type expected = BigDecimal.class;

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.BIG_DECIMAL;

        /* テスト対象の実行 */
        final Type actual = testType.getType();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "型が一致しません");

    }

    /**
     * get メソッドのテスト
     */
    @Test
    public void testGet() {

        /* 期待値の定義 */
        final String expected = "4バイト整数";

        /* 準備 */
        final KmgDbDataTypeTypes testType = KmgDbDataTypeTypes.INTEGER;

        /* テスト対象の実行 */
        final String actual = testType.get();

        /* 検証の実施 */
        Assertions.assertEquals(expected, actual, "取得値が一致しません");

    }
}
