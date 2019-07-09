import React from "react"; 

class Newsletter extends React.Component { 
    constructor(props) {
        super(props);
    } 
    
    render() { 
        return (
            <div className="newsletter">
                <div className="container">
                    <div className="row">
                        <div className="col">
                            <div className="newsletter_border"></div>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-lg-8 offset-lg-2">
                            <div className="newsletter_content text-center">
                                <div className="newsletter_title">{this.props.newsletterTitle}</div>
                                <div className="newsletter_text">
                                    <p>{this.props.newsletterText}</p>
                                </div>
                                <div className="newsletter_form_container">
                                    <form action="#" id="newsletter_form" className="newsletter_form">
                                        <input type="email" className="newsletter_input" required="required" />
                                        <button className="newsletter_button trans_200"><span>{this.props.newsletterButtonText}</span></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 
export default Newsletter;