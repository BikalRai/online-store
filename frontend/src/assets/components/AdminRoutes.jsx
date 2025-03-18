import { Route, Routes } from "react-router-dom";
import Products from "../pages/adminPages/Products";
import Dashboard from "../pages/adminPages/Dashboard";
import Customers from "../pages/adminPages/Customers";
import Orders from "../pages/adminPages/Orders";
import Sales from "../pages/adminPages/Sales";
import Settings from "../pages/adminPages/Settings";

export default function AdminRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Dashboard />} />
      <Route path="/products" element={<Products />} />
      <Route path="/customers" element={<Customers />} />
      <Route path="/orders" element={<Orders />} />
      <Route path="/sales" element={<Sales />} />
      <Route path="/settings" element={<Settings />} />
    </Routes>
  );
}
