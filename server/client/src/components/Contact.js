import React from 'react'; 

class Contact extends React.Component { 
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
                                    <form action="#" id="contact_form" className="contact_form">
                                        <div className="row">
                                            <div className="col-xl-6">
                                                <label for="contact_name">First Name*</label>
                                                <input type="text" id="contact_name" className="contact_input" required="required" />
                                            </div>
                                            <div className="col-xl-6 last_name_col">
                                                <label for="contact_last_name">Last Name*</label>
                                                <input type="text" id="contact_last_name" className="contact_input" required="required" />
                                            </div>
                                        </div>
                                        <div>
                                            <label for="contact_company">Subject</label>
                                            <input type="text" id="contact_company" className="contact_input" />
                                        </div>
                                        <div>
                                            <label for="contact_textarea">Message*</label>
                                            <textarea id="contact_textarea" className="contact_input contact_textarea" required="required"></textarea>
                                        </div>
                                        <button className="button contact_button"><span>Send Message</span></button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div className="col-lg-3 offset-xl-1 contact_col">
                            <div className="contact_info">
                                <div className="contact_info_section">
                                    <div className="contact_info_title">Marketing</div>
                                    <ul>
                                        <li>Phone: <span>123-456-7890</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
                                </div>
                                <div className="contact_info_section">
                                    <div className="contact_info_title">Shippiing & Returns</div>
                                    <ul>
                                        <li>Phone: <span>123-456-7890</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
                                </div>
                                <div className="contact_info_section">
                                    <div className="contact_info_title">Information</div>
                                    <ul>
                                        <li>Phone: <span>123-456-7890</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default Contact;