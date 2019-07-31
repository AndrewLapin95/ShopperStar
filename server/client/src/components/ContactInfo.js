import React from "react"; 

class ContactInfo extends React.Component { 
    render() { 
        return (
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
        ); 
    } 
}

export default ContactInfo;