# SauceDemo BDD Framework: Advanced E-Commerce Flow

## Overview
This repository contains a modular BDD (Behavior-Driven Development) automation framework built as a professional portfolio project. It automates high-priority user journeys (Multi-User Login $\rightarrow$ Inventory Sorting $\rightarrow$ Checkout Validation) on the Sauce Labs e-commerce application using a scalable architecture.

## Tech Stack
**Language:** Java (JDK 21 LTS)

**Automation Tool:** Selenium WebDriver (v4)

**BDD Framework:** Cucumber

**Test Runner:** TestNG

**Build Tool:** Maven

## Automated Scenarios
**Authentication:** Implements a Data-Driven `Scenario Outline` to verify both successful logins and specific error message triggers for locked-out or invalid users.

**Sorting Logic:** Validates the "Price (low to high)" sorting functionality by implementing advanced synchronization that monitors for dynamic text changes in the UI.

**Identity Verification:** Processes the checkout flow to ensure the application correctly handles shipping information for specific roster requirements, such as the identity of **Adriano Chelentano**.


## Testing Best Practices Applied
**Page Object Model (POM):** Decouples test logic from UI locators by centralizing element interactions within dedicated page classes, significantly reducing maintenance overhead.

**Centralized Driver Management:** Utilizes a `DriverFactory` to manage browser instances, configured with **Incognito Mode** and custom arguments to bypass browser-level security alerts and password manager popups.

**Explicit Wait Synchronization:** Employs `WebDriverWait` to handle race conditions during page transitions and dynamic content updates, ensuring 100% test stability without using brittle sleep commands.

**Lifecycle Management:** Implements centralized `Hooks` to handle browser setup and teardown, ensuring a clean environment for every scenario and preventing orphaned driver processes.