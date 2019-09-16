import React from 'react'; 
import axios from "axios";
    
class Cart extends React.Component { 
    
    constructor(props) { 
        super(props); 

        this.state = { 
            cart: {},
            products: [],
            userId: ""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateState = this.updateState.bind(this);
        this.updateDeliveryMethod = this.updateDeliveryMethod.bind(this);
    }

    async handleSubmit(event) {

        event.preventDefault();

        axios.delete("/api/delete-items/" + this.state.userId).then(res => {
            console.log(res);
        });

        this.updateState();

    }

    async updateState() {
        
        const user = await axios.get("/api/current_user/"); 
        
        await axios.post("/api/create-cart/" + user.data._id);

        const cart = await axios.get("/api/get-cart/" + user.data._id);
        const updatedProducts = cart.data.products;

        for (let i = 0; i < updatedProducts.length; i++) {
            const curProduct = await axios.get("/api/get-product/" + updatedProducts[i].productId)
            updatedProducts[i].productUrl = curProduct.data.images[0].imageUri;
        }
  
        this.setState({
            userId: user.data._id,
            cart: cart.data,
            products: updatedProducts
        });

        this.forceUpdate();

    }

    async updateDeliveryMethod(newDeliveryMethod) {
        
        await axios.post("/api/update-delivery-method/" + this.state.userId, {
            deliveryMethod: newDeliveryMethod
        }).then(res => {
            console.log(res);
        });

        const cart = await axios.get("/api/get-cart/" + this.state.userId);

        this.setState({
            cart: cart.data,
        });

        this.forceUpdate();
    }

    async componentDidMount() {
        this.updateState();
    }
    
    render() { 

        let totalPrice = this.state.cart.totalPrice;
        let shippingPrice = "Free";

        if (this.state.cart.deliveryMethod == "STANDARD_DELIVERY") { 
            shippingPrice = "$5"; 
        } else if (this.state.cart.deliveryMethod == "NEXT_DAY_DELIVERY") { 
            shippingPrice = "$25";
        } 

        const renderedProducts = this.state.products.map((product) => {
                
                const productUrl = "/product/" + product.productId;
                const totalPrice = product.productPrice * product.count;

                return <div className="row cart_items_row">
                    <div className="col">

                        <div className="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                            <div className="cart_item_product d-flex flex-row align-items-center justify-content-start">
                                <div className="cart_item_image">
                                    <div><img src={product.productUrl} alt="" /></div>
                                </div>
                                <div className="cart_item_name_container">
                                    <div className="cart_item_name"><a href={productUrl}>{product.productTitle}</a></div>
                                    <div className="cart_item_edit"><a href={productUrl}>See More</a></div>
                                </div>
                            </div>

                            <div className="cart_item_price">${product.productPrice}</div>

                            <div className="cart_item_quantity">
                                <div className="product_quantity_container">
                                    <div className="product_quantity clearfix">
                                        <span>Qty</span>
                                        <input id="quantity_input" type="text" pattern="[0-9]*" value={product.count} />
                                        <div className="quantity_buttons">
                                            <div id="quantity_inc_button" className="quantity_inc quantity_control"></div>
                                            <div id="quantity_dec_button" className="quantity_dec quantity_control"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="cart_item_total">${totalPrice}</div>
                        </div>
                    </div>
                </div>;          
        });

        return (
            <div className="super_container">
                <div className="cart_info">
                    <div className="container">
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

                            <div className="cart_summarisation">
                                {renderedProducts}
                            
                                <div className="row row_cart_buttons">
                                    <div className="col">
                                        <div className="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
                                            <div className="button newsletter_button"><a href="/products">Continue shopping</a></div>
                                            <div className="cart_buttons_right ml-lg-auto">
                                                <form onSubmit={this.handleSubmit} id="clear_cart_form" className="newsletter_form">
                                                    <button className="button newsletter_button trans_200"><span>Clear cart</span></button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        <div className="row row_extra">
                            <div className="col-lg-4">
                                <div className="delivery">
                                    <div className="section_title">Shipping method</div>
                                    <div className="section_subtitle">Select the one you want</div>
                                    <div className="delivery_options">
                                        <form name="UpdateDelivery" onSubmit={this.handleUpdate}>
                                            <label className="delivery_option clearfix">Next day delivery
                                                    <input onClick={() => this.updateDeliveryMethod("NEXT_DAY_DELIVERY")}type="radio" name="radio" value="NEXT_DAY_DELIVERY" />
                                                    <span className="checkmark"></span>
                                                    <span className="delivery_price">$25</span>
                                            </label>
                                            <label className="delivery_option clearfix">Standard delivery
                                                    <input onClick={() => this.updateDeliveryMethod("STANDARD_DELIVERY")} type="radio" name="radio" value="STANDARD_DELIVERY" />
                                                    <span className="checkmark"></span>
                                                    <span className="delivery_price">$5</span>
                                            </label>
                                            <label className="delivery_option clearfix">Personal pickup
                                                    <input onClick={() => this.updateDeliveryMethod("PICKUP")} type="radio" name="radio" value="PICKUP" />
                                                    <span className="checkmark"></span>
                                                    <span className="delivery_price">Free</span>
                                            </label>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 offset-lg-2">
                                <div className="cart_total">
                                    <div className="section_title">Cart total</div>
                                    <div className="section_subtitle">Final info</div>
                                    <div className="cart_total_container">
                                        <ul>
                                            <li className="d-flex flex-row align-items-center justify-content-start">
                                                <div className="cart_total_title">Shipping</div>
                                                <div className="cart_total_value ml-auto">{shippingPrice}</div>
                                            </li>
                                            <li className="d-flex flex-row align-items-center justify-content-start">
                                                <div className="cart_total_title">Total</div>
                                                <div className="cart_total_value ml-auto">${totalPrice}</div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div className="button newsletter_button"><a href="/checkout">Checkout</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    }
} 

export default Cart;