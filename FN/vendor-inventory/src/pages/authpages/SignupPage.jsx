import { useState } from "react";
import {Button} from "../../components/generalComponents/Button";
import {InputField} from "../../components/generalComponents/InputField";

import { useNavigate } from "react-router-dom";

export const SignupPage = () => {
  const [formData, setFormData] = useState({ name: "", email: "", password: "", confirmPassword: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSignUp = (e) => {
    e.preventDefault();
    if (formData.password !== formData.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }
    console.log("Sign Up Data:", formData); // Replace with actual sign-up logic
  };

  const goBack = () => {
    navigate(-1); // Navigate to the previous page
  };

  return (
    <div className="vh-100 d-flex">
      {/* Left Side - Full Image */}
      <div
        className="signup-image"
        style={{
          flex: "60%",
          backgroundImage: "url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=600&auto=format&fit=crop&q=60')",
          backgroundSize: "cover",
          backgroundPosition: "center",
        }}
      ></div>

      {/* Right Side - Sign Up Form */}
      <div
        className="signup-form d-flex justify-content-center align-items-center"
        style={{
          flex: "40%",
          backgroundColor: "#f8f9fa",
        }}
      >
        <div
          className="card p-3 w-100"
          style={{
            maxWidth: "400px",
            border: "1px solid #ddd",
            boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
          }}
        >
          <h3 className="text-center mb-1" style={{ color: "#00B207" }}>
            Sign Up
          </h3>
          <form onSubmit={handleSignUp}>
            <InputField
              label="Full Name"
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              placeholder="Enter your full name"
            />
            <InputField
              label="Email Address"
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              placeholder="Enter your email"
            />
            <InputField
              label="Password"
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              placeholder="Enter your password"
            />
            <InputField
              label="Confirm Password"
              type="password"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleChange}
              placeholder="Confirm your password"
            />
            <Button text="Sign Up" type="submit" styleClass="btn-success" />
          </form>

          <div className="text-center mt-1">
            <span>Already have an account?</span>{" "}
            <a
              href="#"
              onClick={() => navigate("/auth/login")}
              style={{ textDecoration: "underline", color: "#00B207" }}
            >
              Login
            </a>
          </div>

          <div className="text-center mt-1">
            <Button text="Go Back" styleClass="btn-secondary" onClick={goBack} />
          </div>
        </div>
      </div>
    </div>
  );
};
