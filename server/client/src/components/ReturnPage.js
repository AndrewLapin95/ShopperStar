import React from "react"; 
import Newsletter from "./Newsletter"; 
import IconBoxes from "./IconBoxes"; 

class ReturnPageMain extends React.Component { 
    constructor(props) {
        super(props);
    }
    
    render() {
        return (
            <div className="return_page">
                <div className="row">
                    <div className="col-lg-8 offset-lg-2">
                        <div className="return_content text-center">
                            <div className="return_text">{this.props.text}</div>
                            <div className="return_form_container">
                                <form action="/" id="return_form" className="return_form">
                                    <button className="return_button trans_200"><span>{this.props.button}</span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    } 
} 

class ReturnPage extends React.Component { 
    render() { 
        return (
            <div className="super_container">
                <ReturnPageMain text="Your order has been placed!" 
                                button="Continue Shopping" />
                <IconBoxes />
                <Newsletter newsletterTitle="Subscribe to our newsletter" 
                            newsletterText="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie eros" 
                            newsletterButtonText="Subscribe" />
            </div>
        ) 
    } 
} 

export default ReturnPage;