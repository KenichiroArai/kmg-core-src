package kmg.core.infrastructure.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * KMGデシマル<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class KmgDecimal {

    /**
     * 計算用ゼロ
     *
     * @since 0.1.0
     */
    public static final BigDecimal CALC_ZERO = BigDecimal.ZERO.setScale(KmgDecimal.CALC_SCALE);

    /**
     * 計算用スケール
     *
     * @since 0.1.0
     */
    private static final int CALC_SCALE = 15;

    /**
     * 計算用丸めモード
     *
     * @since 0.1.0
     */
    private static final RoundingMode CALC_ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * 結果用ゼロ
     *
     * @since 0.1.0
     */
    public static final BigDecimal RESULT_ZERO = BigDecimal.ZERO.setScale(KmgDecimal.RESULT_SCALE);

    /**
     * 結果用スケール
     *
     * @since 0.1.0
     */
    private static final int RESULT_SCALE = 3;

    /**
     * 結果用丸めモード
     *
     * @since 0.1.0
     */
    private static final RoundingMode RESULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    /**
     * 値
     *
     * @since 0.1.0
     */
    private BigDecimal value;

    /**
     * 除算する<br>
     * <p>
     * num1 ÷ num2
     * </p>
     *
     * @since 0.1.0
     *
     * @param num1
     *             数値１
     * @param num2
     *             数値２
     *
     * @return 除算結果
     */
    public static BigDecimal divide(final BigDecimal num1, final BigDecimal num2) {

        final BigDecimal result = num1.divide(num2, KmgDecimal.CALC_SCALE, KmgDecimal.CALC_ROUNDING_MODE);
        return result;

    }

    /**
     * 計算用のスケールを設定する<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     *
     * @return スケール設定後の巨大デシマル
     */
    public static BigDecimal setCalcScale(final BigDecimal value) {

        final BigDecimal result = value.setScale(KmgDecimal.CALC_SCALE, KmgDecimal.CALC_ROUNDING_MODE);
        return result;

    }

    /**
     * 計算用のスケールを設定する<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     *
     * @return スケール設定後の巨大デシマル
     */
    public static BigDecimal setCalcScale(final double value) {

        final BigDecimal result = KmgDecimal.setCalcScale(new BigDecimal(value));
        return result;

    }

    /**
     * 結果用のスケールを設定する<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     *
     * @return スケール設定後の巨大デシマル
     */
    public static BigDecimal setResultScale(final BigDecimal value) {

        final BigDecimal result = value.setScale(KmgDecimal.RESULT_SCALE, KmgDecimal.RESULT_ROUNDING_MODE);
        return result;

    }

    /**
     * 結果用のスケールを設定する<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     *
     * @return スケール設定後の巨大デシマル
     */
    public static BigDecimal setResultScale(final double value) {

        final BigDecimal result = KmgDecimal.setResultScale(new BigDecimal(value));
        return result;

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     */
    public KmgDecimal(final BigDecimal value) {

        this.value = value;
        this.setCalcScale();

    }

    /**
     * コンストラクタ<br>
     *
     * @since 0.1.0
     *
     * @param value
     *              値
     */
    public KmgDecimal(final double value) {

        final String strVal = String.valueOf(value);
        this.value = new BigDecimal(strVal);
        this.setCalcScale();

    }

    /**
     * 値を返す<br>
     *
     * @since 0.1.0
     *
     * @return 値
     */
    public BigDecimal getValue() {

        final BigDecimal result = this.value;
        return result;

    }

    /**
     * 計算用のスケールを設定する<br>
     *
     * @since 0.1.0
     */
    private void setCalcScale() {

        this.value = KmgDecimal.setCalcScale(this.value);

    }

}
