package kmg.core.infrastructure.types;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import kmg.core.infrastructure.type.KmgString;

/**
 * KMG区切り文字の種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum KmgDelimiterTypes implements Supplier<String> {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", null),

    /** ピリオド */
    PERIOD("ピリオド", "."),

    /** カンマ */
    COMMA("カンマ", ","),

    /** コロン */
    COLON("コロン", "."),

    /** バーティカルバー */
    VERTICAL_BAR("バーティカルバー", "|"),

    /** アンダースコア */
    UNDERSCORE("アンダースコア", "_"),

    /** スラッシュ */
    SLASH("スラッシュ", "/"),

    /** ハイフン */
    HYPHEN("ハイフン", "-"),

    /** 半角スペース */
    HALF_SPACE("半角スペース", KmgString.HALF_SPACE),

    /** プラス */
    PLUS("プラス", "+"),

    /** 全角コロン */
    ALL_COLON("全角コロン", "："),

    /** 全角読点 */
    ALL_IDEOGRAPHIC("全角読点", "、"),

    /** 連続半角スペース */
    SERIES_HALF_SPACE("連続半角スペース", "\\s+"),

    /** 改行 */
    LINE_SEPARATOR("改行", KmgString.LINE_SEPARATOR),

    /** 半角イコール */
    HALF_EQUAL("半角イコール", "="),

    /* 定義：終了 */
    ;

    /** 種類のマップ */
    private static final Map<String, KmgDelimiterTypes> valuesMap = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final KmgDelimiterTypes type : KmgDelimiterTypes.values()) {

            KmgDelimiterTypes.valuesMap.put(type.get(), type);

        }

    }

    /** 名称 */
    private final String name;

    /** 値 */
    private final String value;

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 初期値
     */
    public static KmgDelimiterTypes getDefault() {

        final KmgDelimiterTypes result = NONE;
        return result;

    }

    /**
     * 値に該当する種類を返す<br>
     * <p>
     * 但し、値が存在しない場合は、指定無し（NONE）を返す
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param value
     *              値
     * @return 種類。指定無し（NONE）：値が存在しない場合
     */
    public static KmgDelimiterTypes getEnum(final String value) {

        KmgDelimiterTypes result = KmgDelimiterTypes.valuesMap.get(value);

        if (result == null) {

            result = NONE;

        }

        return result;

    }

    /**
     * 初期値の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 初期値
     */
    public static KmgDelimiterTypes getInitValue() {

        final KmgDelimiterTypes result = NONE;
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @since 1.0.0
     * @version 1.0.0
     * @param name
     *              名称
     * @param value
     *              値
     */
    KmgDelimiterTypes(final String name, final String value) {

        this.name = name;
        this.value = value;

    }

    /**
     * 種類の値<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 種類の値
     */
    @Override
    public String get() {

        final String result = this.value;
        return result;

    }

    /**
     * 名称を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 名称
     */
    public String getName() {

        final String result = this.name;
        return result;

    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    public String getValue() {

        final String result = this.value;
        return result;

    }

    /**
     * 結合する文字列リストにデリミタを付加して文字列を返す<br>
     * <p>
     * 但し、結合する文字列がnullまたは空文字の場合は結合しない
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param <T>
     *                   結合する文字列の型
     * @param targetList
     *                   結合する文字列リスト
     * @return 結合する文字列リストにデリミタを付加した文字列
     */
    public <T> String join(final List<T> targetList) {

        final String result = this.join(targetList.toArray(new Object[0]));
        return result;

    }

    /**
     * 結合する文字列にデリミタを付加して文字列を返す<br>
     * <p>
     * 結合する文字列にnullまたは空文字があるの場合はその結合する文字列を含めない。<br>
     * 結合する文字列がnullの場合は空文字を返す。<br>
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param targets
     *                結合する文字列
     * @return 結合する文字列にデリミタを付加した文字列
     */
    public String join(final Object... targets) {

        String result = KmgString.EMPTY;

        if (targets == null) {

            return result;

        }

        final StringBuilder sb = new StringBuilder();

        for (final Object target : targets) {

            if (target == null) {

                continue;

            }

            if (KmgString.isEmpty(target.toString())) {

                continue;

            }

            sb.append(target.toString());
            sb.append(this.value);

        }

        if (sb.length() > 1) {

            result = sb.substring(0, sb.length() - 1).toString();

        }

        return result;

    }

    /**
     * 結合する文字列にデリミタを付加して文字列を返す<br>
     * <p>
     * 結合する文字列にnullまたは空文字があるの場合はそのまま結合する<br>
     * 結合する文字列がnullの場合は空文字を返す。<br>
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param targets
     *                結合する文字列
     * @return 結合する文字列にデリミタを付加した文字列
     */
    public String joinAll(final Object... targets) {

        String result = KmgString.EMPTY;

        if ((targets == null) || (targets.length == 0)) {

            return result;

        }

        // リストが渡された場合は配列に変換
        Object[] targetArray = targets;

        if ((targets.length == 1) && (targets[0] instanceof final List<?> list)) {

            targetArray = list.toArray();

        }

        final StringBuilder sb = new StringBuilder();

        for (final Object target : targetArray) {

            if (target == null) {

                sb.append("null");

            } else {

                sb.append(target.toString());

            }
            sb.append(this.value);

        }

        if (sb.length() > 1) {

            result = sb.substring(0, sb.length() - 1).toString();

        }

        return result;

    }

    /**
     * 分割する文字列を分割し、文字列の配列にして返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param target
     *               分割する文字列
     * @return 分割した文字列の配列
     */
    public String[] split(final String target) {

        String[] result = null;

        if (KmgString.isEmpty(target)) {

            return result;

        }

        result = target.split(this.value);

        return result;

    }

    /**
     * 分割する文字列を分割し、文字列の配列にして返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param target
     *               分割する文字列
     * @param limit
     *               制限数
     * @return 分割した文字列の配列
     */
    public String[] split(final String target, final int limit) {

        String[] result = null;

        if (KmgString.isEmpty(target)) {

            return result;

        }

        result = target.split(this.value, limit);

        return result;

    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    @Override
    public String toString() {

        final String result = this.value;
        return result;

    }
}
