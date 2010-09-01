/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 * 
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 * 
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 * 
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.worldwake;

import java.util.UUID;
import mage.Constants.CardType;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldStaticAbility;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.effects.common.EntersBattlefieldTappedEffect;
import mage.abilities.mana.GreenManaAbility;
import mage.cards.CardImpl;
import mage.game.permanent.token.Token;
import mage.sets.Worldwake;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class KhalniGarden extends CardImpl<KhalniGarden> {

	public KhalniGarden(UUID ownerId) {
		super(ownerId, "Khalni Garden", new CardType[]{CardType.LAND}, null);
		this.expansionSetId = Worldwake.getInstance().getId();
		this.addAbility(new EntersBattlefieldStaticAbility(new EntersBattlefieldTappedEffect()));
		this.addAbility(new EntersBattlefieldTriggeredAbility(new CreateTokenEffect(new PlantToken()), false));
		this.addAbility(new GreenManaAbility());
	}

	public KhalniGarden(final KhalniGarden card) {
		super(card);
	}

	@Override
	public KhalniGarden copy() {
		return new KhalniGarden(this);
	}

	@Override
	public String getArt() {
		return "123552_typ_reg_sty_010.jpg";
	}

}

class PlantToken extends Token {

	public PlantToken() {
		super("Plant", "0/1 green Plant creature");
		cardType.add(CardType.CREATURE);
		color.setGreen(true);
		subtype.add("Plant");
		power = new MageInt(0);
		toughness = new MageInt(1);
	}

}