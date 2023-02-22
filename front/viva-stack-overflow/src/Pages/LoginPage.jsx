import LoginForm from "../components/modules/LoginForm";
import Footer2 from "../components/templates/Footer2"
import Sidebar from "../components/templates/Sidebar";
import Header2 from "../components/templates/Header/Header2";



function LoginPage() {

    return (
        <>
            <Header2 />
            <Sidebar />
            <LoginForm />
            <Footer2 />
        </>

    )
}

export default LoginPage;