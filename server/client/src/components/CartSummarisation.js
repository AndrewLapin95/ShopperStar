import React from "react"; 

class CartItem extends React.Component {
    constructor(props) {
        super(props);
        this.cartImageUrl = "https://shopperstar.s3.amazonaws.com/cart_1.jpg";
    }
    
    render() { 
        return (
            <div className="row cart_items_row">
                <div className="col">

                    <div className="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                        <div className="cart_item_product d-flex flex-row align-items-center justify-content-start">
                            <div className="cart_item_image">
                                <div><img src={this.props.image} alt="" /></div>
                            </div>
                            <div className="cart_item_name_container">
                                <div className="cart_item_name"><a href="#">{this.props.itemName}</a></div>
                                <div className="cart_item_edit"><a href="#">{this.props.editProductText}</a></div>
                            </div>
                        </div>

                        <div className="cart_item_price">{this.props.itemPrice}</div>

                        <div className="cart_item_quantity">
                            <div className="product_quantity_container">
                                <div className="product_quantity clearfix">
                                    <span>Qty</span>
                                    <input id="quantity_input" type="text" pattern="[0-9]*" value="1" />
                                    <div className="quantity_buttons">
                                        <div id="quantity_inc_button" className="quantity_inc quantity_control"><i className="fa fa-chevron-up" aria-hidden="true"></i></div>
                                        <div id="quantity_dec_button" className="quantity_dec quantity_control"><i className="fa fa-chevron-down" aria-hidden="true"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="cart_item_total">$790.90</div>
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
                <div className="row">
                    <div className="col">
                        <div className="cart_info_columns clearfix">
                            <div className="cart_info_col cart_info_col_product">Product</div>
                            <div className="cart_info_col cart_info_col_price">Price</div>
                            <div className="cart_info_col cart_info_col_quantity">Quantity</div>
                            <div className="cart_info_col cart_info_col_total">Total</div>
                        </div>
                    </div>
                </div>
                
                <CartItem image={this.cartImageUrl}
                          itemName="Smart Phone Deluxe Edition"
                          editProductText="Edit Product"
                          itemPrice="$790.00"/>

                <div className="row row_cart_buttons">
                    <div className="col">
                        <div className="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
                            <div className="button continue_shopping_button"><a href="#">Continue shopping</a></div>
                            <div className="cart_buttons_right ml-lg-auto">
                                <div className="button clear_cart_button"><a href="#">Clear cart</a></div>
                                <div className="button update_cart_button"><a href="#">Update cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default CartSummarisation;