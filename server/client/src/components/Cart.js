import React from 'react';
import DeliveryPanel from "./DeliveryPanel";
import CartTotal from "./CartTotal";
import CartSummarisation from "./CartSummarisation"; 

class Cart extends React.Component { 
    render() { 
        return (
            <div class="super_container">
                <div class="cart_info">
                    <div class="container">
                        <CartSummarisation />
                        <div class="row row_extra">
                            <div class="col-lg-4">
                                <DeliveryPanel />
                            </div>
                            <div class="col-lg-6 offset-lg-2">
                                <CartTotal />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Cart;