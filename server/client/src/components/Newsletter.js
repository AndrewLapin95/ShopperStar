import React from "react";
import axios from 'axios';

class Newsletter extends React.Component { 
    
    constructor(props) {

        super(props);

        this.state = { email: "" }
        
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        
    } 
    
    handleChange(event) {

        this.setState({ [event.target.name]: event.target.value });

    }

    handleSubmit(event) {

        event.preventDefault();

        axios.post("/api/subscribe", {
            
            email: this.state.email

        }).then(res => {
            console.log(res);
        });

        this.setState({ 
            email: ""
         });

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
                                    <form onSubmit={this.handleSubmit} id="newsletter_form" className="newsletter_form">
                                        <input name="email" type="email" value={this.state.email} onChange={this.handleChange} className="newsletter_input" required="required"/>
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