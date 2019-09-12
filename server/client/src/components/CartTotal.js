import React from "react"; 

class CartTotal extends React.Component {
    
    constructor(props) {
        super(props);
    }

    render() { 
        return (
            <div className="cart_total">
                <div className="section_title">Cart total</div>
                <div className="section_subtitle">Final info</div>
                <div className="cart_total_container">
                    <ul>
                        <li className="d-flex flex-row align-items-center justify-content-start">
                            <div className="cart_total_title">Shipping</div>
                            <div className="cart_total_value ml-auto">${this.props.shippingPrice}</div>
                        </li>
                        <li className="d-flex flex-row align-items-center justify-content-start">
                            <div className="cart_total_title">Total</div>
                            <div className="cart_total_value ml-auto">${this.props.totalPrice}</div>
                        </li>
                    </ul>
                </div>
                <div className="button checkout_button"><a href="/checkout">Proceed to checkout</a></div>
            </div>
        ); 
    } 
} 
export default CartTotal;