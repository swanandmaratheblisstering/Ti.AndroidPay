package ti.androidpayment;

/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */

import java.math.BigDecimal;
import java.util.ArrayList;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;

import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.Cart.Builder;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;

import android.app.Activity;

// This proxy can be created by calling Androidpayment.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = AndroidpaymentModule.class)
public class CartProxy extends KrollProxy {
	// Standard Debugging variables
	private static final String LCAT = AndroidpaymentModule.LCAT;
	private static final boolean DBG = TiConfig.LOGD;
	private String currencyCode = "USD";
	private BigDecimal totalPrice = BigDecimal.ZERO;
	private ArrayList<LineItem> items;
	private Cart cart;

	// Constructor
	public CartProxy() {
		super();
	}

	@Override
	public void handleCreationDict(KrollDict opts) {
		super.handleCreationDict(opts);
		if (opts.containsKeyAndNotNull("CurrencyCode")) {
			currencyCode = opts.getString("CurrencyCode");
		}
		if (opts.containsKeyAndNotNull("TotalPrice")) {
			totalPrice = new BigDecimal(opts.getDouble("TotalPrice"));
		}
	}

	// Methods
	@Kroll.method
	public void addLineItem(LineItemProxy proxy) {
		items.add(proxy.getItem());
	}
	
	public Cart getCart() {
		 Builder builder = Cart.newBuilder()
	    .setCurrencyCode(currencyCode)
	    .setTotalPrice(String.valueOf(totalPrice));
	    for (LineItem item : items) {
	    	builder.addLineItem(item);
	    }
	    return builder.build();
	}
}