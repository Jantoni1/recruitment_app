package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;

import java.math.BigInteger;

class TwoTypeRewardCalculator {

    private final static BigInteger ONE_HUNDRED = BigInteger.valueOf(100);
    private final static BigInteger FIFTY = BigInteger.valueOf(50);

    BigInteger calculatePurchaseReward(Purchase purchase) {
        var amountInteger = purchase.getAmount().toBigInteger();
        return calculateDoubleBonus(amountInteger).add(calculateSingleBonus(amountInteger));
    }

    private BigInteger calculateSingleBonus(BigInteger amount) {
        if(FIFTY.compareTo(amount) > 0) {
            return BigInteger.ZERO;
        }

        return ONE_HUNDRED.min(amount).subtract(FIFTY);
    }

    private BigInteger calculateDoubleBonus(BigInteger amount) {
        if(ONE_HUNDRED.compareTo(amount) > 0) {
            return BigInteger.ZERO;
        }

        return amount.subtract(ONE_HUNDRED).multiply(BigInteger.valueOf(2));
    }

}
