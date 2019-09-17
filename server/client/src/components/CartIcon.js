import React from "react";
import axios from "axios";
import { connect } from 'react-redux';

class CartIcon extends React.Component {
    
    state = { itemsCount: 0 };

    async componentDidMount() {
        const user = await axios.get("/api/current_user/");
        const cart = await axios.get("/api/get-cart/" + user.data._id);
        
        this.setState({
            itemsCount: cart.data.productCount
        });
    }

    renderContent() {
        
        var curState = "(" + this.state.itemsCount + ")";

        if (this.props.auth == false) {
            return "";
        } else {
            return <a href="/cart">
                <div><i className="far fa-shopping-cart fa-lg"></i></div>
                <div>{curState}</div>
            </a>;
        }
    }

    render() {
        return (
            <span>{this.renderContent()}</span>
        );
    }

}

function mapStateToProps({ auth }) {
    return { auth };
}

export default connect(mapStateToProps)(CartIcon);