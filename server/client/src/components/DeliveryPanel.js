import React from "react"; 

class DeliveryOption extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <label class="delivery_option clearfix">{this.props.text}
                    <input type="radio" name="radio" />
                    <span class="checkmark"></span>
                    <span class="delivery_price">{this.props.price}</span>
            </label>
        );
    }
}

class DeliveryPanel extends React.Component { 
    
    render() { 
        return (
            <div class="delivery">
                <div class="section_title">Shipping method</div>
                <div class="section_subtitle">Select the one you want</div>
                <div class="delivery_options">
                    <DeliveryOption text="Next day delivery"
                                    price="$4.99" />
                    <DeliveryOption text="Standard delivery"
                                    price="$1.99" /> 
                    <DeliveryOption text="Personal pickup"
                                    price="Free" />
                </div>
            </div>
    ); 
    } 
} 

export default DeliveryPanel;