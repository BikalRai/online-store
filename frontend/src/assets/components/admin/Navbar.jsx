import { useState } from "react";
import {
  LuLayoutDashboard,
  LuPackage2,
  LuSettings,
  LuShoppingCart,
  LuTag,
  LuUsers,
} from "react-icons/lu";
import { NavLink } from "react-router-dom";
import NavigationLink from "../NavigationLink";

export default function Navbar() {
  const [activeLink, setActiveLink] = useState("dashboard");

  const handleActiveLinkName = (linkName) => {
    setActiveLink(linkName);
  };
  return (
    <nav className="flex flex-col bg-light min-h-dvh sticky items-center p-5 max-w-[215px] gap-5 top-0 rounded-r-lg">
      <div className="logo">
        <a href="" className="text-h1 text-primary font-bold ">
          Logo
        </a>
      </div>
      <ul className="grid gap-5">
        <li>
          <NavigationLink
            linkName="dashboard"
            linkIcon={<LuLayoutDashboard />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
        <li>
          <NavigationLink
            linkName="products"
            linkIcon={<LuPackage2 />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
        <li>
          <NavigationLink
            linkName="customers"
            linkIcon={<LuUsers />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
        <li>
          <NavigationLink
            linkName="orders"
            linkIcon={<LuShoppingCart />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
        <li>
          <NavigationLink
            linkName="sales"
            linkIcon={<LuTag />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
        <li>
          <NavigationLink
            linkName="settings"
            linkIcon={<LuSettings />}
            activeLink={activeLink}
            handleActiveLinkName={handleActiveLinkName}
          />
        </li>
      </ul>
    </nav>
  );
}
