import { useState } from "react";
import {
  LuLayoutDashboard,
  LuPackage2,
  LuSettings,
  LuShoppingCart,
  LuTag,
  LuUsers,
} from "react-icons/lu";
import NavigationLink from "./NavigationLink";

export default function Navbar() {
  const [activeLink, setActiveLink] = useState("dashboard");

  const handleActiveLinkName = (linkName) => {
    setActiveLink(linkName);
  };
  return (
    <nav className="bg-light sticky top-0 flex min-h-dvh max-w-[215px] flex-col items-center gap-5 rounded-r-lg p-5">
      <div className="text-h2 sm:text-h1 text-primary font-bold">Logo</div>
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
