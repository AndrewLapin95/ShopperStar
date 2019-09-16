import React from "react";
import axios from "axios";

class Checkout extends React.Component {

    constructor(props) {
        
        super(props);

        this.state = {
            userId: "",
            firstName: "",
            lastName: "",
            company: "",
            country: "",
            address: "",
            zipCode: "",
            city: "",
            province: "",
            phoneNumber: "",
            totalPrice: "",
            deliveryMethod: "",
        };
        
        this.updateState = this.updateState.bind(this);
        this.handleSubmit = this.updateState.bind(this);
    }

    async updateState() {

        const user = await axios.get("/api/current_user/");
        const cart = await axios.get("/api/get-cart/" + user.data._id);
        
        this.setState({
            userId: user.data._id,
            totalPrice: cart.data.totalPrice,
            deliveryMethod: cart.data.deliveryMethod,
        });
    }

    async handleSubmit(event) {

        event.preventDefault();
        
        await axios.post('/api/save-address/' + this.state.userId, {
            userId: this.state.userId,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            company: this.state.company,
            country: this.state.country,
            address: this.state.address,
            zipCode: this.state.zipCode,
            city: this.state.city,
            province: this.state.province,
            phoneNumber: this.state.phoneNumber,
        })

        await axios.post('/api/save-order-details/' + this.state.userId);
    }

    async componentDidMount() {
        this.updateState();
    }

    render() {

        let shippingPrice = "$0";

        if (this.state.deliveryMethod == "STANDARD_DELIVERY") { 
            shippingPrice = "$5"; 
        } else if (this.state.deliveryMethod == "NEXT_DAY_DELIVERY") { 
            shippingPrice = "$25";
        } 

        let deliveryType = "Pickup";

        if (this.state.deliveryMethod == "STANDARD_DELIVERY") { 
            deliveryType = "Standard Delivery";
        } else if (this.state.deliveryMethod == "NEXT_DAY_DELIVERY") { 
            deliveryType = "Next Day Delivery";
        } 

        console.log(this.state);
        return (
            <div className="super_container">
                <div className="checkout">
                    <div className="container">
                        <form onSubmit={this.handleSubmit} id="checkout_form" className="checkout_form">
                            <div className="row">
                                <div className="col-lg-6">
                                    <div className="billing checkout_section">
                                        <div className="section_title">Enter your address info</div>
                                        <div className="checkout_form_container">
                                                <div className="row">
                                                    <div className="col-xl-6">
                                                        <label>First Name*</label>
                                                        <input onChange={e => this.setState({ firstName: e.target.value })} type="text" id="checkout_name" className="checkout_input" required="required" />
                                                    </div>
                                                    <div className="col-xl-6 last_name_col">
                                                        <label>Last Name*</label>
                                                        <input onChange={e => this.setState({ lastName: e.target.value })} type="text" id="checkout_last_name" className="checkout_input" required="required" />
                                                    </div>
                                                </div>
                                                <div>
                                                    <label>Company</label>
                                                    <input onChange={e => this.setState({ company: e.target.value })} type="text" id="checkout_company" className="checkout_input" />
                                                </div>
                                                <div>
                                                    <label>Country*</label>
                                                    <input onChange={e => this.setState({ country: e.target.value })} type="text" id="checkout_country" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>Address*</label>
                                                    <input onChange={e => this.setState({ address: e.target.value })} type="text" id="checkout_address" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>Zipcode*</label>
                                                    <input onChange={e => this.setState({ zipCode: e.target.value })} type="text" id="checkout_zipcode" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>City/Town*</label>
                                                    <input onChange={e => this.setState({ city: e.target.value })} type="text" id="checkout_city" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>Province*</label>
                                                    <input onChange={e => this.setState({ province: e.target.value })} type="text" id="checkout_province" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>Phone no*</label>
                                                    <input onChange={e => this.setState({ phoneNumber: e.target.value })} type="phone" id="checkout_phone" className="checkout_input" required="required" />
                                                </div>
                                                <div>
                                                    <label>Email Address*</label>
                                                    <input onChange={e => this.setState({ email: e.target.value })} type="phone" id="checkout_email" className="checkout_input" required="required" />
                                                </div>
                                        </div>
                                    </div>
                                </div>

                                <div className="col-lg-6">
                                    <div className="order checkout_section">
                                        <div className="section_title">Your order</div>
                                        <div className="section_subtitle">Order details</div>

                                        <div className="order_list_container">
                                            <ul className="order_list">
                                                <li className="d-flex flex-row align-items-center justify-content-start">
                                                    <div className="order_list_title">Shipping</div>
                                                    <div className="order_list_value ml-auto">{deliveryType}</div>
                                                </li>
                                                <li className="d-flex flex-row align-items-center justify-content-start">
                                                    <div className="order_list_title">Total</div>
                                                    <div className="order_list_value ml-auto">${this.state.totalPrice}</div>
                                                </li>
                                            </ul>
                                        </div>

                                        <div className="order_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra temp or so dales. Phasellus sagittis auctor gravida. Integ er bibendum sodales arcu id te mpus. Ut consectetur lacus.</div>
                                        <button className="button newsletter_button trans_200"><a href="/return">Place Order</a></button>
                                    </div>
                                </div>
                                
                            </div>
                            </form>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Checkout;