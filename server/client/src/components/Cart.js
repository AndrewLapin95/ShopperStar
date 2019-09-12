import React from 'react';
import DeliveryPanel from "./DeliveryPanel";
import CartTotal from "./CartTotal";
import CartSummarisation from "./CartSummarisation";
import axios from "axios";

class Cart extends React.Component { 
    
    constructor(props) {
        
        super(props);

        this.state = {
            cart: {}
        }
    }

    async componentDidMount() {

        const user = await axios.get("/api/current_user/");
        const createCart = await axios.post("/api/create-cart/" + user.data._id);
        const cart = await axios.get("/api/get-cart/" + user.data._id);

        this.setState({
            cart: cart.data
        });
    }
    
    render() {
        
        var totalPrice = this.state.cart.totalPrice;
        var shippingPrice = "Free";
        
        if (this.state.cart.deliveryMethod == "STANDARD_DELIVERY") {
            shippingPrice = "1.99";
        } else if (this.state.cart.deliveryMethod == "NEXT_DAY_DELIVERY") {
            shippingPrice = "4.99";
        }

        return (
            <div className="super_container">
                <div className="cart_info">
                    <div className="container">
                        <CartSummarisation />
                        <div className="row row_extra">
                            <div className="col-lg-4">
                                <DeliveryPanel />
                            </div>
                            <div className="col-lg-6 offset-lg-2">
                                <CartTotal  totalPrice={totalPrice}
                                            shippingPrice={shippingPrice}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Cart;