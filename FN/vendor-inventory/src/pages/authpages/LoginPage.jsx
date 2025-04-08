import { useState } from "react";
import { InputField } from "../../components/index";
import { Button } from "../../components/index";
import { GoogleAuthButton } from "../../components/index";
import { useNavigate } from "react-router-dom";

export const LoginPage = () => {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleLogin = (e) => {
    e.preventDefault();
    console.log("Login Data:", formData); // Replace with actual login logic
    // Navigate to home or dashboard page after successful login
    navigate("/auth/two-f-auth"); // Update with correct navigation path
  };

  const handleGoogleLogin = () => {
    console.log("Google Login Clicked"); // Replace with actual Google login logic
  };

  const goBack = () => {
    navigate(-1); // Navigate to the previous page
  };

  return (
    <div className="vh-100 d-flex">
      {/* Left Side - Full Image */}
      <div
        className="login-image"
        style={{
          flex: "60%",
          backgroundImage: "url('https://images.unsplash.com/photo-1511690656952-34342bb7c2f2?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8ZnJlc2glMjBoZWFydGglMjBvcmdhbmljJTIwZm9vZHxlbnwwfHwwfHx8MA%3D%3D')",
          backgroundSize: "cover",
          backgroundPosition: "center",
        }}
      ></div>

      {/* Right Side - Login Form */}
      <div
        className="login-form d-flex justify-content-center align-items-center"
        style={{
          flex: "40%",
          backgroundColor: "#f8f9fa",
        }}
      >
        <div
          className="card p-4 w-100"
          style={{
            maxWidth: "400px",
            border: "1px solid #ddd",
            boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
          }}
        >
          <h3 className="text-center mb-2" style={{ color: "#00B207" }}>
            Login
          </h3>
          <form onSubmit={handleLogin}>
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
            <Button text="Login" type="submit" styleClass="btn-success" />
          </form>

          <div className="text-center mt-2">
            <Button
              text="Sign Up with Email"
              styleClass="btn-outline-primary"
              onClick={() => navigate("/auth/signup")}
            />
            <GoogleAuthButton onClick={handleGoogleLogin} />
          </div>

          <div className="text-center mt-2">
            <a
              href="#"
              onClick={() => navigate("/auth/forgot-password")}
              style={{ textDecoration: "underline", color: "#00B207" }}
            >
              Forgot Password?
            </a>
          </div>

          <div className="text-center mt-2">
            <span>Don’t have an account?</span>{" "}
            <a
              href="#"
              onClick={() => navigate("/auth/signup")}
              style={{ textDecoration: "underline", color: "#00B207" }}
            >
              Sign Up
            </a>
          </div>

          <div className="text-center mt-2">
            <Button text="Go Back" styleClass="btn-secondary" onClick={goBack} />
          </div>
        </div>
      </div>
    </div>
  );
};
