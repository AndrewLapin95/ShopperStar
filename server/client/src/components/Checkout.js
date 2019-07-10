import React from "react"; 

import Check from "./images/check.png"; 

class Checkout extends React.Component { 
    render() { 
        return (
            <div className="super_container">
                <div class="checkout">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-6">
                                <div class="billing checkout_section">
                                    <div class="section_title">Billing Address</div>
                                    <div class="checkout_extra">
                                        <div>
                                            <input type="checkbox" id="saved_address" name="regular_checkbox" class="regular_checkbox" />
                                            <label for="checkbox_account"><img src={Check} alt="" /></label>
                                            <span class="checkbox_title">Use saved address (address goes here)</span>
                                        </div>
                                    </div>
                                    <div class="section_title">Enter your address info</div>
                                    <div class="checkout_form_container">
                                        <form action="#" id="checkout_form" class="checkout_form">
                                            <div class="row">
                                                <div class="col-xl-6">
                                                    <label for="checkout_name">First Name*</label>
                                                    <input type="text" id="checkout_name" class="checkout_input" required="required" />
                                                </div>
                                                <div class="col-xl-6 last_name_col">
                                                    <label for="checkout_last_name">Last Name*</label>
                                                    <input type="text" id="checkout_last_name" class="checkout_input" required="required" />
                                                </div>
                                            </div>
                                            <div>
                                                <label for="checkout_company">Company</label>
                                                <input type="text" id="checkout_company" class="checkout_input" />
                                            </div>
                                            <div>
                                                <label for="checkout_country">Country*</label>
                                                <select name="checkout_country" id="checkout_country" class="dropdown_item_select checkout_input" require="required">
                                                    <option></option>
                                                    <option>Lithuania</option>
                                                    <option>Sweden</option>
                                                    <option>UK</option>
                                                    <option>Italy</option>
                                                </select>
                                            </div>
                                            <div>
                                                <label for="checkout_address">Address*</label>
                                                <input type="text" id="checkout_address" class="checkout_input" required="required" />
                                                <input type="text" id="checkout_address_2" class="checkout_input checkout_address_2" required="required" />
                                            </div>
                                            <div>
                                                <label for="checkout_zipcode">Zipcode*</label>
                                                <input type="text" id="checkout_zipcode" class="checkout_input" required="required" />
                                            </div>
                                            <div>
                                                <label for="checkout_city">City/Town*</label>
                                                <select name="checkout_city" id="checkout_city" class="dropdown_item_select checkout_input" require="required">
                                                    <option></option>
                                                    <option>City</option>
                                                    <option>City</option>
                                                    <option>City</option>
                                                    <option>City</option>
                                                </select>
                                            </div>
                                            <div>
                                                <label for="checkout_province">Province*</label>
                                                <select name="checkout_province" id="checkout_province" class="dropdown_item_select checkout_input" require="required">
                                                    <option></option>
                                                    <option>Province</option>
                                                    <option>Province</option>
                                                    <option>Province</option>
                                                    <option>Province</option>
                                                </select>
                                            </div>
                                            <div>
                                                <label for="checkout_phone">Phone no*</label>
                                                <input type="phone" id="checkout_phone" class="checkout_input" required="required" />
                                            </div>
                                            <div>
                                                <label for="checkout_email">Email Address*</label>
                                                <input type="phone" id="checkout_email" class="checkout_input" required="required" />
                                            </div>
                                            <div class="checkout_extra">
                                                <div>
                                                    <input type="checkbox" id="checkbox_account" name="regular_checkbox" class="regular_checkbox" />
                                                    <label for="checkbox_account"><img src={Check} alt="" /></label>
                                                    <span class="checkbox_title">Save address</span>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6">
                                <div class="order checkout_section">
                                    <div class="section_title">Your order</div>
                                    <div class="section_subtitle">Order details</div>

                                    <div class="order_list_container">
                                        <div class="order_list_bar d-flex flex-row align-items-center justify-content-start">
                                            <div class="order_list_title">Product</div>
                                            <div class="order_list_value ml-auto">Total</div>
                                        </div>
                                        <ul class="order_list">
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Cocktail Yellow dress</div>
                                                <div class="order_list_value ml-auto">$59.90</div>
                                            </li>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Subtotal</div>
                                                <div class="order_list_value ml-auto">$59.90</div>
                                            </li>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Shipping</div>
                                                <div class="order_list_value ml-auto">Free</div>
                                            </li>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Total</div>
                                                <div class="order_list_value ml-auto">$59.90</div>
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="payment">
                                        <div class="payment_options">
                                            <label class="payment_option clearfix">Paypal
                                                <input type="radio" name="radio" />
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="payment_option clearfix">Cach on delivery
                                                <input type="radio" name="radio" />
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                    </div>

                                    <div class="order_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra temp or so dales. Phasellus sagittis auctor gravida. Integ er bibendum sodales arcu id te mpus. Ut consectetur lacus.</div>
                                    <div class="button order_button"><a href="/return">Place Order</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Checkout;