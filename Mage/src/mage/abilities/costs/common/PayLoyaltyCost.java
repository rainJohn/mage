/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.abilities.costs.common;

import mage.abilities.Ability;
import mage.abilities.costs.CostImpl;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class PayLoyaltyCost extends CostImpl<PayLoyaltyCost> {

	private int amount;

	public PayLoyaltyCost(int amount) {
		this.amount = amount;
		this.text = Integer.toString(amount) + " loyalty";
	}

	public PayLoyaltyCost(PayLoyaltyCost cost) {
		super(cost);
		this.amount = cost.amount;
	}

	@Override
	public boolean canPay(Ability source, Game game) {
		Permanent planeswalker = game.getPermanent(source.getSourceId());
		if (planeswalker.getLoyalty().getValue() + amount >= 0 && !planeswalker.isLoyaltyUsed())
			return true;
		return false;
	}

	@Override
	public boolean pay(Game game, Ability source, boolean noMana) {
		Permanent planeswalker = game.getPermanent(source.getSourceId());
		if (planeswalker.getLoyalty().getValue() + amount > 0 && !planeswalker.isLoyaltyUsed()) {
			planeswalker.getLoyalty().boostValue(amount);
			planeswalker.setLoyaltyUsed(true);
			this.paid = true;
		}
		return paid;
	}

	@Override
	public PayLoyaltyCost copy() {
		return new PayLoyaltyCost(this);
	}

}
