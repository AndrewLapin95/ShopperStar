import React from "react";

class CartIcon extends React.Component {
    state = { itemsCount: 0 };
    
    getState() {
        return "(" + this.state.itemsCount + ")";
    }

    render() {
        return (
            <a href="/cart">
                <div><i className="far fa-shopping-cart fa-lg"></i></div>
                <div>{this.getState()}</div>
            </a>
        );
    }

}

export default CartIcon;