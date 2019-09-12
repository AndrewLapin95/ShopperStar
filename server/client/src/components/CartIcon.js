import React from "react";
import axios from "axios";

class CartIcon extends React.Component {
    
    state = { itemsCount: 0 };

    async componentDidMount() {
        const user = await axios.get("/api/current_user/");
        const cart = await axios.get("/api/get-cart/" + user.data._id);
        
        this.setState({
            itemsCount: cart.data.productCount
        });
    }

    render() {
        var curState = "(" + this.state.itemsCount + ")";

        return (
            <a href="/cart">
                <div><i className="far fa-shopping-cart fa-lg"></i></div>
                <div>{curState}</div>
            </a>
        );
    }

}

export default CartIcon;