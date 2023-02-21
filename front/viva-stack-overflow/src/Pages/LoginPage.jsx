import LoginForm from "../components/modules/LoginForm";
import Footer from "../components/templates/Footer";
import Header from "../components/templates/Header";
import Sidebar from "../components/templates/Sidebar";




function LoginPage() {

    return (
        <>
            <Sidebar />
            <Header />
            <LoginForm />
            <Footer />
        </>

    )
}

export default LoginPage;