import '../Estilos/login.css'
import { DiApple } from "react-icons/di";
import { FaFacebook, FaGoogle } from "react-icons/fa";
import { Link } from 'react-router-dom';

export const Login = () => {
  return (
    <div className="app-content">
      <div className="image-boxl">
        <img src="../public/imagens/logo-packids.png" alt="Pac Kids Logo" />
      </div>
      <section className="login-container">
        <form className="login-form">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            required
            placeholder="Digite seu email"
          />

          <label htmlFor="password">Senha:</label>
          <input
            type="password"
            id="password"
            name="password"
            required
            placeholder="Digite sua senha"
          />
        </form>
          <Link type="submit" className="login-button" to='/home'>
            Login
          </Link>
      </section>
      <footer>
          <div className="login-options">
            <div className="login-opt"><FaFacebook/></div>
            <div className="login-opt"><DiApple/></div>
            <div className="login-opt"><FaGoogle/></div>
          </div>
      </footer>
    </div>
  )
}

export default Login;
