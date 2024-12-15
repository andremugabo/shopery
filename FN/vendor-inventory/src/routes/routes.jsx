import { createBrowserRouter } from "react-router";
import * as Layouts from '../layouts/index';
import * as Pages from '../pages/index';

export const router = createBrowserRouter([
    {
        path:'/',
        element:<Layouts.RootLayout/>,
        children:[
            {index:true, element:<Pages.HomePage/>},
            {path:'/shop', element:<Pages.Shop/>}
        ]
    }
])