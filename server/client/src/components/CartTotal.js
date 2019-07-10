import React from "react"; 

class CartTotal extends React.Component { 
    render() { 
        return (
            <div class="cart_total">
                <div class="section_title">Cart total</div>
                <div class="section_subtitle">Final info</div>
                <div class="cart_total_container">
                    <ul>
                        <li class="d-flex flex-row align-items-center justify-content-start">
                            <div class="cart_total_title">Subtotal</div>
                            <div class="cart_total_value ml-auto">$790.90</div>
                        </li>
                        <li class="d-flex flex-row align-items-center justify-content-start">
                            <div class="cart_total_title">Shipping</div>
                            <div class="cart_total_value ml-auto">Free</div>
                        </li>
                        <li class="d-flex flex-row align-items-center justify-content-start">
                            <div class="cart_total_title">Total</div>
                            <div class="cart_total_value ml-auto">$790.90</div>
                        </li>
                    </ul>
                </div>
                <div class="button checkout_button"><a href="#">Proceed to checkout</a></div>
            </div>
        ); 
    } 
} 
export default CartTotal;