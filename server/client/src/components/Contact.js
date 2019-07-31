import React from 'react';
import axios from 'axios';
import ContactInfo from "./ContactInfo";

class Contact extends React.Component {

    constructor(props) {

        super(props);

        this.state = {

            firstName: "",
            lastName: "",
            subject: "",
            message: ""

        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleChange(event) {

        this.setState({ [event.target.name]: event.target.value });

    }

    handleSubmit(event) {

        event.preventDefault();
        
        axios.post("/api/save-contact", {
            
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            subject: this.state.subject,
            message: this.state.message

        }).then(res => {
            console.log(res);
        });

        this.setState({ 

            firstName: "",
            lastName: "",
            subject: "",
            message: ""

         });
    }

    render() { 
        return (
            <div className="contact">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-8 contact_col">
                            <div className="get_in_touch">
                                <div className="section_title">Get in Touch</div>
                                <div className="section_subtitle">Say Hello</div>
                                <div className="contact_form_container">
                                    <form onSubmit={this.handleSubmit} id="contact_form" className="contact_form">
                                        <div className="row">
                                            <div className="col-xl-6">
                                                <label for="contact_name">First Name*</label>
                                                <input name="firstName" value={this.state.firstName} onChange={this.handleChange} type="text" id="contact_name" className="contact_input" required="required" />
                                            </div>
                                            <div className="col-xl-6 last_name_col">
                                                <label for="contact_last_name">Last Name*</label>
                                                <input name="lastName" value={this.state.lastName} onChange={this.handleChange} type="text" id="contact_last_name" className="contact_input" required="required" />
                                            </div>
                                        </div>
                                        <div>
                                            <label for="contact_company">Subject</label>
                                            <input name="subject" value={this.state.subject} onChange={this.handleChange} type="text" id="contact_company" className="contact_input" />
                                        </div>
                                        <div>
                                            <label for="contact_textarea">Message*</label>
                                            <textarea name="message" value={this.state.message} onChange={this.handleChange} id="contact_textarea" className="contact_input contact_textarea" required="required"></textarea>
                                        </div>
                                        <button className="button contact_button"><span>Send Message</span></button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <ContactInfo />
                        
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Contact;