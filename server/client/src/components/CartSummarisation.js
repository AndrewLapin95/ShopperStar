import React from "react"; 

import Cart1 from "./images/cart_1.jpg"; 

class CartItem extends React.Component {
    constructor(props) {
        super(props);
    }
    
    render() { 
        return (
            <div class="row cart_items_row">
                <div class="col">

                    <div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                        <div class="cart_item_product d-flex flex-row align-items-center justify-content-start">
                            <div class="cart_item_image">
                                <div><img src={this.props.image} alt="" /></div>
                            </div>
                            <div class="cart_item_name_container">
                                <div class="cart_item_name"><a href="#">{this.props.itemName}</a></div>
                                <div class="cart_item_edit"><a href="#">{this.props.editProductText}</a></div>
                            </div>
                        </div>

                        <div class="cart_item_price">{this.props.itemPrice}</div>

                        <div class="cart_item_quantity">
                            <div class="product_quantity_container">
                                <div class="product_quantity clearfix">
                                    <span>Qty</span>
                                    <input id="quantity_input" type="text" pattern="[0-9]*" value="1" />
                                    <div class="quantity_buttons">
                                        <div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
                                        <div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cart_item_total">$790.90</div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

class CartSummarisation extends React.Component { 
    render() { 
        return (
            <div className="cart_summarisation">
                <div class="row">
                    <div class="col">
                        <div class="cart_info_columns clearfix">
                            <div class="cart_info_col cart_info_col_product">Product</div>
                            <div class="cart_info_col cart_info_col_price">Price</div>
                            <div class="cart_info_col cart_info_col_quantity">Quantity</div>
                            <div class="cart_info_col cart_info_col_total">Total</div>
                        </div>
                    </div>
                </div>
                
                <CartItem image={Cart1}
                          itemName="Smart Phone Deluxe Edition"
                          editProductText="Edit Product"
                          itemPrice="$790.00"/>

                <div class="row row_cart_buttons">
                    <div class="col">
                        <div class="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
                            <div class="button continue_shopping_button"><a href="#">Continue shopping</a></div>
                            <div class="cart_buttons_right ml-lg-auto">
                                <div class="button clear_cart_button"><a href="#">Clear cart</a></div>
                                <div class="button update_cart_button"><a href="#">Update cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default CartSummarisation;